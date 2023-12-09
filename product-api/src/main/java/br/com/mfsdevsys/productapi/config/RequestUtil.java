package br.com.mfsdevsys.productapi.config;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.mfsdevsys.productapi.config.exception.ValidationException;
import jakarta.servlet.http.HttpServletRequest;

public class RequestUtil {
	
	@SuppressWarnings("null")
	public static HttpServletRequest getCurrentRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .getRequest();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ValidationException("The current request could not be proccessed.");
        }
    }

}
