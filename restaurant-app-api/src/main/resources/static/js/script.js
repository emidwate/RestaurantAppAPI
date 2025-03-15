import { getFoodList } from "./food/fetchFoodList.js"
import { getOrderList } from "./customerOrder/fetchOrder.js"
import { renderFoodList } from "./food/renderFoodList.js"
import { renderOrderList } from "./customerOrder/renderOrderList.js"
import { addNewFood } from "./food/addNewFood.js"
import { validateForm } from "./formValidation/validateForm.js"

document.addEventListener('DOMContentLoaded', async () => {
    try {
        const foodList = await getFoodList()
        const orderList = await getOrderList()
        renderFoodList(foodList)
        renderOrderList(orderList)
    } catch (error) {
        console.error('Failed to render:', error)
    }
})

// Form food handler

const addFoodButton = document.getElementById("add-food-btn")

addFoodButton.addEventListener("click", async () => {
    const message = document.getElementById("form-message")

    const foodData = {
        name: `${document.getElementById("food-name").value}`,
        ingredients: `${document.getElementById("food-ingredients").value}`,
        price: parseFloat(document.getElementById("food-price").value),
        emoji: `${document.getElementById("food-emoji").value}`
    }

    if (validateForm(foodData)) {
        await addNewFood(foodData)
        document.getElementById("add-food-form").reset()
        message.textContent = ""
    } else {
        message.textContent = "Please put appropiate data in the form fields"
    }

})


