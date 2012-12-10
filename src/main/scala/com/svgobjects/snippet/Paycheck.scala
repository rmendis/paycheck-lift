package com.svgobjects
package snippet

import net.liftweb.http.S
import net.liftweb.http.SHtml
import net.liftweb.util.Helpers.strToCssBindPromoter
import net.liftweb.http.SessionVar

/**
 * The secret as a session var
 */
object TheSecret extends SessionVar("")

/**
 * The stateless form
 */
class Paycheck {
  def render = {
    def process() =
      S.redirectTo("/einstein")

    // set the secret
    "name=secret" #> SHtml.onSubmit(TheSecret.set _) & // set the secret
      // when the form is submitted vend the einstein SVG
    "type=submit" #> SHtml.onSubmitUnit(process)
  }
}

/**
 * stateless 
 */
class Einstein {
  def secret = "#secret *" #> TheSecret.get
}
