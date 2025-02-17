package com.bitsunisage.e_commerce.config;


import com.bitsunisage.e_commerce.entity.Product;
import com.bitsunisage.e_commerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * Disables the methods that needs to be restricted using HttpMethod[] unsupportedActions array
 */
@Configuration
public class RestConfigurations implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {


        HttpMethod[] unsupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
        config
                .getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metadata, httpMethods) ->
                        httpMethods
                                .disable(unsupportedActions)
                )
                .withCollectionExposure((metadata, httpMethods) ->
                        httpMethods
                                .disable(unsupportedActions));
        config
                .getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metadata, httpMethods) ->
                        httpMethods
                                .disable(unsupportedActions)
                )
                .withCollectionExposure((metadata, httpMethods) ->
                        httpMethods
                                .disable(unsupportedActions));

    }


}
