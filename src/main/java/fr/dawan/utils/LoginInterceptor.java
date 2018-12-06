package fr.dawan.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private List<String> ignoreList;
	
	public List<String> getIgnoreList() {
		return ignoreList;
	}

	public void setIgnoreList(List<String> ignoreList) {
		this.ignoreList = ignoreList;
	}

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestedUrl = request.getRequestURI();
		boolean urlAIgnorer = false;
		//l'url est elle dans la liste des urls à ignorer ?
		for (String urlIgnoree : ignoreList) {
			//l'url cherchée correspond à une url à ignorer
			if (requestedUrl.contains(urlIgnoree)) {
				urlAIgnorer = true;
				break;
			}

		}
		// si ce n'est pas une url à ignorer (typiquement /login)
		if (!urlAIgnorer) {
			Object joueur = request.getSession().getAttribute("joueur");
			//on n'a pas de user dans la session, donc user pas identifié
			if (joueur == null) {
				//on redirige vers controller login
				request.getRequestDispatcher("/login").forward(request, response);
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		super.afterConcurrentHandlingStarted(request, response, handler);
	}


}
