package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter( urlPatterns = {"/*"})
public class EncodingFilter implements Filter {

    @Override
    public void doFilter( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) throws IOException, ServletException {

        ((HttpServletRequest)servletRequest).setCharacterEncoding( "UTF-8" );
        filterChain.doFilter( servletRequest, servletResponse );
    }
}
