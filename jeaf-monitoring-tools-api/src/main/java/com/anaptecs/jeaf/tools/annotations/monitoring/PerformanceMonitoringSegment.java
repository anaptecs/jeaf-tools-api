/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.tools.annotations.monitoring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * By default performance monitoring tools are gathering information only on level of the overall request (e.g. a REST
 * call). However if you need more fine grained information about where time is spent by an application you can define
 * so called segments. Segments will be shown in performance reports a part of the overall transaction.
 * 
 * This annotation can be used to define a method as a segment. The annotation is independent of a specific monitoring
 * solution.
 * 
 * @author JEAF Development Team
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PerformanceMonitoringSegment {
}
