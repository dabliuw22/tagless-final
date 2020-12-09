package com.leysoft.algebra

trait Apply[F[_]] extends Functor[F] {
  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]
  def productR[A, B](fa: F[A])(fb: F[B]): F[B] =
    ap(fmap(fa)(_ => (b: B) => b))(fb)
}

object Apply {
  def apply[F[_]](implicit F: Apply[F]): Apply[F] = F
}
