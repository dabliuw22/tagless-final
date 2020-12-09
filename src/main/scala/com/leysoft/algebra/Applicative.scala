package com.leysoft.algebra

trait Applicative[F[_]] extends Apply[F] {
  def pure[A](x: A): F[A]
  def unit: F[Unit] = pure(())
}

object Applicative {
  def apply[F[_]](implicit F: Applicative[F]): Applicative[F] = F
}
