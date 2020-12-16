package com.leysoft.syntax

import com.leysoft.algebra.Apply

private[syntax] trait ApplySyntax {

  implicit final class ToApplySyntax[F[_], A](val fa: F[A])(implicit
    F: Apply[F]
  ) {
    def ap[B](ff: F[A => B]): F[B] = F.ap(ff)(fa)

    def <*>[B](ff: F[A => B]): F[B] = fa.ap(ff)

    def *>[B](fb: F[B]): F[B] = F.productR(fa)(fb)
  }
}
