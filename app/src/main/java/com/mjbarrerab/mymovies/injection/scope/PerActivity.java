package com.mjbarrerab.mymovies.injection.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by miller.barrera
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
