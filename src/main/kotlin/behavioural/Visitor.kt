package behavioural

/**
 * Visitor is a behavioural pattern used in scenarios where you have set of objects
 * and you need to perform some actions on them without actually modifying the objects.
 */
fun main() {
    val heading = Heading()
    val subtitle = Subtitle()
    val document = setOf(heading, subtitle)

    val exportToPdfVisitor = ExportToPdfVisitor()
    val exportToCsvVisitor = ExportToCsvVisitor()

    document.forEach {
        it.accept(exportToCsvVisitor)
        it.accept(exportToPdfVisitor)
    }
}

// Any element that can accept the visitor for the operation
private interface Element {
    fun accept(visitor: Visitor)
}

// Visitor performs action on object
private interface Visitor {
    fun visit(element: Element)
}

private class ExportToPdfVisitor : Visitor {
    override fun visit(element: Element) {
        //export to pdf
    }
}

private class ExportToCsvVisitor : Visitor {
    override fun visit(element: Element) {
        //export to csv
    }
}

private class Heading : Element {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

private class Subtitle : Element {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

