package com.leysoft.syntax

import com.leysoft.algebra.Functor

private[syntax] trait FunctorSyntax {

  implicit final class ToFunctorSyntax[F[_], A](val fa: F[A]) {
    def fmap[B](f: A => B)(implicit F: Functor[F]): F[B] =
      F.fmap(fa)(f)

    def <>[B](f: A => B)(implicit F: Functor[F]): F[B] =
      fa.fmap(f)
  }
}
