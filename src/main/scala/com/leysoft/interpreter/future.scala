package com.leysoft.interpreter

import com.leysoft.algebra.Functor

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object future {

  implicit object FutureInstance extends Functor[Future] {

    override def fmap[A, B](fa: Future[A])(f: A => B): Future[B] =
      fa.map(f)
  }
}
