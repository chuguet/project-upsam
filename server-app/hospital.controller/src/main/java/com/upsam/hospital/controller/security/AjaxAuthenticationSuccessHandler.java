package com.upsam.hospital.controller.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.upsam.hospital.model.beans.Usuario;

@Component
public class AjaxAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	public AjaxAuthenticationSuccessHandler() {
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		// HttpSession session = request.getSession();
		// DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest)
		// session.getAttribute(WebAttributes.SAVED_REQUEST);
		// check if login is originated from ajax call
		if ("true".equals(request.getHeader("X-Ajax-call"))) {
			setAlwaysUseDefaultTargetUrl(false);
			Usuario usuario = (Usuario) authentication.getPrincipal();
			String jsonUsuario = "{id:" + usuario.getId().toString() + ",nombre:'" + usuario.getNombre() + "',apellidos:'" + usuario.getApellidos() + "'}";
			response.getWriter().print(StringEscapeUtils.escapeHtml4(jsonUsuario));
			response.getWriter().flush();
		}
		else {
			response.sendRedirect("/hospitalServer/home");
		}
	}
}
