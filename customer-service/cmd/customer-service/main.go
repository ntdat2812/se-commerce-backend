package main

import (
	"customer-service/cmd/customer-service/controllers"

	"github.com/gofiber/fiber/v2"
)

func main() {
	app := fiber.New()

	// Install controllers
	customerController := controllers.NewCustomerController(app)
	customerController.RegisterCustomerRoutes()

	

	app.Listen(":3000")
}