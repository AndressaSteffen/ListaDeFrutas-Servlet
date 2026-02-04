import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Frutas")
public class Frutas extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("### ENTROU NO DOPOST ###");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String[] values = request.getParameterValues("frutas");

        out.println("<html><body>");
        out.println("<h2>Frutas que você selecionou:</h2>");

        if (values != null) {
            out.println("<ul>");
            for (String fruta : values) {
                out.println("<li>" + fruta + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>Nenhuma fruta selecionada.</p>");
        }

        out.println("</body></html>");
    }
}
