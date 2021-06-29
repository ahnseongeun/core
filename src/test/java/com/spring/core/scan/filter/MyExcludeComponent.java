package com.spring.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //Class, interface (including annotation type), or enum declaration
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
