package com.cts.classifiedsportal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.classifiedsportal.model.Offer;
import com.cts.classifiedsportal.model.UserModel;

public interface ClassifiedPortalService {
	
	public ModelAndView getLogin();
	public ModelAndView postLogin(@ModelAttribute UserModel user, HttpServletRequest request);
	public ModelAndView viewAllOffers(HttpServletRequest request);
	public ModelAndView addLike(HttpServletRequest request, @RequestParam("offerId") int offerId,
			@RequestParam("empId") int empId);
	public ModelAndView viewOffer(HttpServletRequest request);
	public ModelAndView saveOffer(HttpServletRequest request, @ModelAttribute Offer offer);
	public ModelAndView engageOffer(HttpServletRequest request, @RequestParam("offerId") int offerId);
	public ModelAndView editOffer(HttpServletRequest request, @ModelAttribute Offer offer);
	public ModelAndView viewProfile(HttpServletRequest request);
	public ModelAndView myOffer(HttpServletRequest request);
	public ModelAndView viewOfferById(HttpServletRequest request, @RequestParam("empId") int id);
	public ModelAndView viewOfferByEmpId(HttpServletRequest request);
	public ModelAndView viewTopOfferByLikes(HttpServletRequest request);
	public ModelAndView viewOfferByPostedDate(HttpServletRequest request);
	public ModelAndView viewOfferByDate(HttpServletRequest request, @RequestParam("offByPostedDate") String date);
	public ModelAndView viewOfferByCatId(HttpServletRequest request);
	public ModelAndView viewOfferByCat(HttpServletRequest request, @RequestParam("offCategoryId") int catId);
	public ModelAndView logout(HttpSession session);

	
}
