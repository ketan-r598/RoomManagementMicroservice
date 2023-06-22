package com.project.filter;
<<<<<<< HEAD
=======

>>>>>>> ab7a1c5d0bbf3da33029ff9eb708f7500a50a491
import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

<<<<<<< HEAD
=======
import com.project.session.Session;

>>>>>>> ab7a1c5d0bbf3da33029ff9eb708f7500a50a491
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

<<<<<<< HEAD
public class JWTValidationFilter extends GenericFilterBean{
	
=======
public class JWTValidationFilter extends GenericFilterBean {

>>>>>>> ab7a1c5d0bbf3da33029ff9eb708f7500a50a491
	public static final String BEARER = "Bearer";
	public static final String AUTHORIZATION = "Authorization";

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
<<<<<<< HEAD
	
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		final String authorization = request.getHeader(AUTHORIZATION);
		if(authorization == null || !authorization.startsWith(BEARER)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().println("Auth Header is missing");
		}
		
		else {
		// Bearer tokenValue
		String token = authorization.substring(7);
		try {
			final Claims claims = Jwts.parser().setSigningKey("testsecretkey")
					.parseClaimsJws(token)
					.getBody();
			request.setAttribute("claims", claims);
			System.out.println(claims.getSubject());
			//String role = (String)claims.get("roles");
			//System.out.println(role);
			chain.doFilter(request, response);
			
		}
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().println("Invalid Token");
		}
		}
		
	}
	
	

}
=======

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		Session session = Session.getSession();
		
		final String authorization = request.getHeader(AUTHORIZATION);

		if (authorization == null || !authorization.startsWith(BEARER)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().println("Auth Header is missing");
		}

		else {
			// Bearer tokenValue
			String token = authorization.substring(7);
			System.out.println("I am here");
			
			try {

				final Claims claims = Jwts
									.parser()
									.setSigningKey("testsecretkey")
									.parseClaimsJws(token)
									.getBody();

				request.setAttribute("claims", claims);

				System.out.println(claims.getSubject());
				
				int userId = (int) claims.get("userId");
				String email = (String) claims.getSubject();
				String password = (String) claims.get("password");
				String role = (String) claims.get("role");
				
				if(!role.equalsIgnoreCase("owner")) {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					response.getWriter().println("Permission Denied");
					return;
				}
				
				System.out.println(userId);
				System.out.println(email);
				System.out.println(password);
				System.out.println(role);
				
				session.setUserId(userId);
				session.setEmail(email);
				session.setPassword(password);
				session.setRole(role);
		
				chain.doFilter(request, response);
			
			} catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.getWriter().println("Invalid Token");
			}
		}
	}
}
>>>>>>> ab7a1c5d0bbf3da33029ff9eb708f7500a50a491
