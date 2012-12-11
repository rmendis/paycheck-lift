package com.svgobjects
package snippet

import net.liftweb.http.S
import net.liftweb.http.SHtml
import net.liftweb.util.Helpers.strToCssBindPromoter
import net.liftweb.http.SessionVar

/**
 * The secret as a session var
 */
object TheSecret extends SessionVar[String]("")

/**
 * The stateless form
 */
object Paycheck {
  def render = {
    def process() =
      S.redirectTo("/einstein")

    "name=secret" #> SHtml.onSubmit(TheSecret.set _) & // set the secret
    "type=submit" #> SHtml.onSubmitUnit(process) // on form submission vend the SVG image
  }
}

/**
 * stateless 
 */
object Einstein {
  def secret = "#secret *" #> TheSecret.get
}
