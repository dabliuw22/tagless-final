package com.leysoft.interpreter

import com.leysoft.algebra.{Applicative, Apply, Functor}

object option {

  implicit object OptionInstance
      extends Applicative[Option]
      with Apply[Option]
      with Functor[Option] {

    override def ap[A, B](ff: Option[A => B])(fa: Option[A]): Option[B] =
      ff match {
        case Some(f) => fmap(fa)(f)
        case _       => None
      }

    override def fmap[A, B](fa: Option[A])(f: A => B): Option[B] =
      fa.map(f)

    override def pure[A](x: A): Option[A] = Some(x)
  }
}
