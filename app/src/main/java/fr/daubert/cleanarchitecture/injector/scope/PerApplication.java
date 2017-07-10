package fr.daubert.cleanarchitecture.injector.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by daubert on 07/07/2017.
 */

@Scope
@Retention(value = RetentionPolicy.RUNTIME)
public @interface PerApplication {
}
