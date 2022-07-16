package controllers

import (
	"customer-service/cmd/customer-service/models"
	"net/http"

	"github.com/gofiber/fiber/v2"
)

type customerController struct {
	app *fiber.App
}

func NewCustomerController(app *fiber.App) customerController {
	return customerController{
		app: app,
	}
}

// Routers
func (c *customerController) RegisterCustomerRoutes() {

	customerApi := c.app.Group("/api/customers")

	customerApi.Get("/", c.getCustomerList)
}

func (c *customerController) getCustomerList(ctx *fiber.Ctx) error {
	customer := models.Customer{
		Id: 123,
		Name: "TEST THOI",
	}

	return ctx.Status(http.StatusOK).JSON(customer);
}
