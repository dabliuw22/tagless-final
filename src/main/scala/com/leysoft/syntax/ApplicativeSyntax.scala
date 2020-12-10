package com.leysoft.syntax

import com.leysoft.algebra.Applicative

private[syntax] trait ApplicativeSyntax {

  implicit final class ToApplicativeIdSyntax[F[_], A](val a: A) {
    def pure(implicit F: Applicative[F]): F[A] =
      F.pure(a)
  }
}
