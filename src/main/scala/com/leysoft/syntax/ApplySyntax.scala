package com.leysoft.syntax

import com.leysoft.algebra.Apply

private[syntax] trait ApplySyntax {

  implicit final class ToApplySyntax[F[_], A](val fa: F[A]) {
    def ap[B](ff: F[A => B])(implicit F: Apply[F]): F[B] =
      F.ap(ff)(fa)

    def <*>[B](ff: F[A => B])(implicit F: Apply[F]): F[B] =
      fa.ap(ff)

    def *>[B](fb: F[B])(implicit F: Apply[F]): F[B] =
      F.productR(fa)(fb)
  }
}
