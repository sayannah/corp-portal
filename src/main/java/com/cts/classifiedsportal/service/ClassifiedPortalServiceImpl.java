package com.cts.classifiedsportal.service;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.classifiedsportal.client.AuthClient;
import com.cts.classifiedsportal.client.EmployeeClient;
import com.cts.classifiedsportal.client.OfferClient;
import com.cts.classifiedsportal.client.PointsClient;
import com.cts.classifiedsportal.model.Employee;
import com.cts.classifiedsportal.model.Offer;
import com.cts.classifiedsportal.model.UserModel;
import com.cts.classifiedsportal.model.UserToken;

@Service
public class ClassifiedPortalServiceImpl implements ClassifiedPortalService {

	@Autowired
	AuthClient authClient;

	@Autowired
	OfferClient offerClient;

	@Autowired
	EmployeeClient employeeClient;

	@Autowired
	PointsClient pointsClient;

	@Override
	public ModelAndView getLogin() {
		return new ModelAndView("login");
	}

	@Override
	public ModelAndView postLogin(@ModelAttribute UserModel user, HttpServletRequest request) {
		UserToken res = null;
		try {
			res = authClient.login(user).getBody();
		} catch (Exception e) {
			ModelAndView modelandview = new ModelAndView("login");
			modelandview.addObject("invalidmsg", "Username or password is Invalid");
			return modelandview;
		}
		request.getSession().setAttribute("token", "Bearer " + res.getAuthToken());
		request.getSession().setAttribute("name", user.getEmpUsername());
		request.getSession().setAttribute("empid", res.getEmpid());
		return new ModelAndView("redirect:viewalloffers");
	}

	@Override
	public ModelAndView viewAllOffers(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		String name = (String) request.getSession().getAttribute("name");

		if (token != null) {
			List<Offer> offer = offerClient.getAllOffers(token).getBody();
			ModelAndView modelandview = new ModelAndView("offerlist");
			modelandview.addObject("offlist", offer);
			modelandview.addObject("name", name);
			return modelandview;
		} else {
			return new ModelAndView("login");
		}
	}

	@Override
	public ModelAndView addLike(HttpServletRequest request, int offerId, int empId) {
		String token = (String) request.getSession().getAttribute("token");
		
		offerClient.updateLikes(token, offerId , empId);
		return new ModelAndView("redirect:viewalloffers");
	}

	@Override
	public ModelAndView viewOffer(HttpServletRequest request) {
		return new ModelAndView("addoffer");
	}

	@Override
	public ModelAndView saveOffer(HttpServletRequest request, Offer offer) {
		String token = (String) request.getSession().getAttribute("token");
		int empid = (int) request.getSession().getAttribute("empid");
		if (token != null) {
			if(offer.getClosedDate().isAfter(offer.getOpenedDate())) {
			offer.setEmpId(empid);
			offer.setOfferCategory(offerClient.getCategory(token, offer.getOfferCategoryId()).getBody());
			offer.setPostedDate(LocalDate.now());
			offerClient.addOffer(token, offer);
			return new ModelAndView("redirect:viewalloffers");}
			return new ModelAndView("redirect:viewalloffers");
		}
		return new ModelAndView("login");
	}
	
	@Override
	public ModelAndView editOffer(HttpServletRequest request, @ModelAttribute Offer offer) {
		String token = (String) request.getSession().getAttribute("token");
		int empid = (int) request.getSession().getAttribute("empid");
		int offerId = (int) request.getSession().getAttribute("offerId");
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			if(offer.getClosedDate().isAfter(offer.getOpenedDate())) {
			offer.setEmpId(empid);
			offer.setOfferCategory(offerClient.getCategory(token, offer.getOfferCategoryId()).getBody());
			offerClient.editOffer(token, offer, offerId );
			List<Offer> offerdata = offerClient.getAllOffers(token).getBody();
			ModelAndView mav=new ModelAndView("statusedit");
			mav.addObject("offlist", offerdata);
			mav.addObject("name", name);
			return mav;}
			return new ModelAndView("redirect:viewalloffers");
		}
		return new ModelAndView("login");
	}
	
	@Override
	public ModelAndView engageOffer(HttpServletRequest request, @RequestParam("offerId") int offerId) {
		String token = (String) request.getSession().getAttribute("token");
		int empid = (int) request.getSession().getAttribute("empid");
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			Offer offer = offerClient.getOfferDetails(token, offerId).getBody();
			if(offer.getEngagedDate()!=null) {
				ModelAndView mav=new ModelAndView("nostatus");
				mav.addObject("name", name);
				return mav;
			}
				
			List<Offer> offerdata = offerClient.getAllOffers(token).getBody();
			offerClient.engageOffer(token, offerId, empid );
			ModelAndView mav=new ModelAndView("status");
			mav.addObject("offlist", offerdata);
			mav.addObject("name", name);
			return mav;
		}
		return new ModelAndView("login");
	}

	@Override
	public ModelAndView viewProfile(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		int empid = (int) request.getSession().getAttribute("empid");
		Integer points = 0;
		if (token != null) {
			Employee employee = employeeClient.viewProfile(token, empid).getBody();
			points = pointsClient.getPointsByEmpId(token, empid).getBody();
			ModelAndView modelandview = new ModelAndView("empprofile");
			modelandview.addObject("employee", employee);
			modelandview.addObject("points", points);
			return modelandview;

		}
		return new ModelAndView("login");
	}

	@Override
	public ModelAndView myOffer(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		int empid = (int) request.getSession().getAttribute("empid");
		if (token != null) {
			List<Offer> offer = offerClient.getOfferByEmpId(token, empid).getBody();
			if (!offer.isEmpty()) {
				ModelAndView modelandview = new ModelAndView("myofferlist");
				modelandview.addObject("offerlist", offer);
				return modelandview;
			} else {
				ModelAndView modelandview = new ModelAndView("myofferlist");
				modelandview.addObject("offerempty", "Currently you didn't post anything");
				return modelandview;

			}
		}
		return new ModelAndView("login");
	}

	@Override
	public ModelAndView viewOfferById(HttpServletRequest request, int id) {
		String token = (String) request.getSession().getAttribute("token");
		if (token != null) {
			List<Offer> offer = offerClient.getOfferByEmpId(token, id).getBody();
			if (!offer.isEmpty()) {
				ModelAndView modelandview = new ModelAndView("offerlistbyid");
				modelandview.addObject("offerlist", offer);
				return modelandview;
			} else {
				ModelAndView modelandview = new ModelAndView("offerlistbyid");
				modelandview.addObject("empofferempty", " Currently entered Id doesn't post anything");
				return modelandview;
			}

		}
		return new ModelAndView("login");
	}

	@Override
	public ModelAndView viewOfferByEmpId(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		if (token != null) {
			ModelAndView modelandview = new ModelAndView("getempid");
			return modelandview;

		}
		return new ModelAndView("login");
	}

	@Override
	public ModelAndView viewTopOfferByLikes(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		if (token != null) {
			List<Offer> topOffers = offerClient.getOfferByTopLikes(token).getBody();
			ModelAndView modelandview = new ModelAndView("topoffers");
			modelandview.addObject("topoffers", topOffers);
			return modelandview;

		}
		return new ModelAndView("login");
	}

	@Override
	public ModelAndView viewOfferByPostedDate(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		if (token != null) {
			ModelAndView modelandview = new ModelAndView("getofferbyposteddate");
			return modelandview;

		}
		return new ModelAndView("login");
	}

	@Override
	public ModelAndView viewOfferByDate(HttpServletRequest request, String date) {
		String token = (String) request.getSession().getAttribute("token");
		if (token != null) {
			List<Offer> offer = offerClient.getOfferByPostedDate(token, date).getBody();
			if (!offer.isEmpty()) {
				ModelAndView modelandview = new ModelAndView("viewofferbyposteddate");
				modelandview.addObject("offerlist", offer);
				return modelandview;
			} else {
				ModelAndView modelandview = new ModelAndView("viewofferbyposteddate");
				modelandview.addObject("nodate", "Currently there are no offer available in entered date.");
				return modelandview;

			}

		}
		return new ModelAndView("login");
	}

	@Override
	public ModelAndView viewOfferByCatId(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		if (token != null) {
			ModelAndView modelandview = new ModelAndView("getofferbycat");
			return modelandview;

		}
		return new ModelAndView("login");
	}

	@Override
	public ModelAndView viewOfferByCat(HttpServletRequest request, int catId) {
		String token = (String) request.getSession().getAttribute("token");
		if (token != null) {
			List<Offer> offer = offerClient.getOfferByCategory(token, catId).getBody();
			if (!offer.isEmpty()) {
				ModelAndView modelandview = new ModelAndView("viewofferbycat");
				modelandview.addObject("offerlist", offer);
				return modelandview;
			} else {
				ModelAndView modelandview = new ModelAndView("viewofferbycat");
				modelandview.addObject("categoryempty", "Currently there are no offer available in selected category.");
				return modelandview;

			}

		}
		return new ModelAndView("login");
	}

	@Override
	public ModelAndView logout(HttpSession session) {
		session.setAttribute("token", null);
		session.setAttribute("name", null);
		session.invalidate();
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;

	}

}
