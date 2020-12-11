package com.leysoft

import com.leysoft.algebra.Applicative
import syntax.apply._
import syntax.functor._
import syntax.applicative._

final class Program[F[_]: Applicative]() {
  def pure[A](a: A): F[A] = a.pure
  def map[A, B](fa: F[A])(ff: A => B): F[B] = fa.fmap(ff)
  def ap[A, B](fa: F[A])(ff: F[A => B]): F[B] = fa <*> ff
}
