import scala.xml.{Elem, NodeSeq}

object XmlApp extends App {
  val person:Elem=
    <person>
      <firstName>John</firstName>
      <lastName>Doe</lastName>
      <emails>
        <email type="primary">john.doe@noone.com</email>
        <email type="secondary">john.doe@noone.com</email>
      </emails>
      <address>
        <street>5965 Market Street</street>
        <city>San Francisco</city>
        <zip>94105</zip>
      </address>
    </person>

val seq:NodeSeq=person \ "firstName"
  print(seq+"\n")
  val seq1:NodeSeq=person \\ "email"
  seq1.map(NodeSeq=> println(NodeSeq))

  val seq3:NodeSeq=person \\ "@type"
  seq3.map(NodeSeq=> println(NodeSeq))




}
