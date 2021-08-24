package com.cts.classifiedsportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.classifiedsportal.model.Offer;
import com.cts.classifiedsportal.model.UserModel;
import com.cts.classifiedsportal.service.ClassifiedPortalService;

@Controller
public class ClassifiedPortalController {

	@Autowired
	ClassifiedPortalService classifiedPortalService;

	@RequestMapping(path = "/userlogin", method = RequestMethod.GET)
	public ModelAndView getLogin() {
		return classifiedPortalService.getLogin();

	}

	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView postLogin(@ModelAttribute UserModel user, HttpServletRequest request) {
		return classifiedPortalService.postLogin(user, request);
	}

	
	@RequestMapping(path = "/viewalloffers", method = RequestMethod.GET)
	public ModelAndView viewAllOffers(HttpServletRequest request) {
		return classifiedPortalService.viewAllOffers(request);
	}

	
	@RequestMapping(path = "/addlike", method = RequestMethod.GET)
	public ModelAndView addLike(@RequestParam("offerId") int offerId,
			HttpServletRequest request) {
		int empId = (int)request.getSession().getAttribute("empid");
		return classifiedPortalService.addLike(request, offerId, empId);
	}

	@RequestMapping(path = "/addOffer", method = RequestMethod.GET)
	public ModelAndView saveOffer(HttpServletRequest request) {
		return classifiedPortalService.viewOffer(request);

	}
	
	
	@RequestMapping(path = "/addOffer", method = RequestMethod.POST)
	public ModelAndView addOffer(HttpServletRequest request, @ModelAttribute Offer offer) {
		return classifiedPortalService.saveOffer(request, offer);

	}
	
	@RequestMapping(path = "/engage", method = RequestMethod.GET)
	public ModelAndView engageOffer(HttpServletRequest request,@RequestParam("offerId") int offerId,@RequestParam("empId") int empId) {
		int id = (int)request.getSession().getAttribute("empid");
		if(id==empId)
		{
			return new ModelAndView("redirect:viewalloffers");
		}		
		return classifiedPortalService.engageOffer(request,offerId);
	}

	@RequestMapping(path = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(HttpServletRequest request,@RequestParam("offerId") int offerId,@RequestParam("empId") int empId) {
		int id = (int)request.getSession().getAttribute("empid");
		if(id!=empId)
		{
			return new ModelAndView("redirect:viewalloffers");
		}
		request.getSession().setAttribute("offerId", offerId);
		
		return new ModelAndView("editoffer");

	}
	
	
	@RequestMapping(path = "/editOffer", method = RequestMethod.POST)
	public ModelAndView editOffer(HttpServletRequest request, @ModelAttribute Offer offer) {
		return classifiedPortalService.editOffer(request, offer);

	}
	
	@RequestMapping(path = "/viewprofile", method = RequestMethod.GET)
	public ModelAndView viewProfile(HttpServletRequest request) {
		return classifiedPortalService.viewProfile(request);

	}

	
	@RequestMapping(path = "/myoffer", method = RequestMethod.GET)
	public ModelAndView myOffer(HttpServletRequest request) {
		return classifiedPortalService.myOffer(request);

	}

	@RequestMapping(path = "/viewofferbyid", method = RequestMethod.GET)
	public ModelAndView viewOfferById(HttpServletRequest request, @RequestParam("empId") int id) {
		return classifiedPortalService.viewOfferById(request, id);

	}

	@RequestMapping(path = "/viewoffer", method = RequestMethod.GET)
	public ModelAndView viewOfferByEmpId(HttpServletRequest request) {
		return classifiedPortalService.viewOfferByEmpId(request);

	}

	@RequestMapping(path = "/viewtopofferbylikes", method = RequestMethod.GET)
	public ModelAndView viewTopOfferByLikes(HttpServletRequest request) {
		return classifiedPortalService.viewTopOfferByLikes(request);

	}

	
	@RequestMapping(path = "/viewofferbyposteddate", method = RequestMethod.GET)
	public ModelAndView viewOfferByPostedDate(HttpServletRequest request) {
		return classifiedPortalService.viewOfferByPostedDate(request);

	}

	
	@RequestMapping(path = "/viewofferbydate", method = RequestMethod.GET)
	public ModelAndView viewOfferByDate(HttpServletRequest request, @RequestParam("offByPostedDate") String date) {
		return classifiedPortalService.viewOfferByDate(request, date);
	}


	@RequestMapping(path = "/viewofferbycatid", method = RequestMethod.GET)
	public ModelAndView viewOfferByCatId(HttpServletRequest request) {
		return classifiedPortalService.viewOfferByCatId(request);

	}

	@RequestMapping(path = "/viewofferbycat", method = RequestMethod.GET)
	public ModelAndView viewOfferByCat(HttpServletRequest request, @RequestParam("offCategoryId") int catId) {
		return classifiedPortalService.viewOfferByCat(request, catId);

	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		return classifiedPortalService.logout(session);

	}
}
