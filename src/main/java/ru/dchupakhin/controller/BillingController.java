package ru.dchupakhin.controller;

import ru.dchupakhin.model.BillingRequest;
import ru.dchupakhin.model.BillingResponse;
import ru.dchupakhin.model.BillingStatus;
import ru.dchupakhin.model.BillingSystem;
import ru.dchupakhin.service.BillingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/billing")
public class BillingController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BillingRequest billing = BillingRequest.mapFromRequest(req);
        // Доп параметр в запросе 'system', для определения платежной системы.
        BillingSystem system = Enum.valueOf(BillingSystem.class, req.getParameter("system").toUpperCase());
        BillingResponse status = new BillingService().process(billing, system);

        // для возврата ошибок можно сделать ExceptionHandler, который будет возвращать правильные коды,
        // в зависимости от статуса обработки платежа
        if (BillingStatus.SUCCESS.equals(status.getStatus())) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
//            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, status.getErrorMessage());
        }
    }
}
