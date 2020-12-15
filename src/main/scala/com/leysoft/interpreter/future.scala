package com.leysoft.interpreter

import com.leysoft.algebra.Functor

import scala.concurrent.{ExecutionContext, Future}

object future {

  implicit def futureInstance(implicit ctx: ExecutionContext): Functor[Future] =
    new Functor[Future] {
      override def fmap[A, B](fa: Future[A])(f: A => B): Future[B] =
        fa.map(f)(ctx)
    }
}
