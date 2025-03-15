import { removeFoodItem } from "./removeFoodItem.js"
import { addFoodToOrder } from "../customerOrder/addFoodToOrder.js"
import { findFoodById } from "./findFoodById.js"

export function renderFoodList(foodList) {
    const foodContainer = document.getElementById('food-container')

    foodContainer.innerHTML = ''
    foodList.forEach(food => {
        const foodItem = document.createElement('div')
        foodItem.classList.add('food-item') 
        foodItem.innerHTML = `
            <h2>${food.emoji || ''} ${food.name}</h2>
            <p><strong>Ingredients:</strong> ${food.ingredients.split(",")}</p>
            <p><strong>Price:</strong> $${food.price.toFixed(2)}</p>
            <div id="order-btns-container">
                <button class="remove-btn" data-id="${food.id}">-</button>
                <button class="add-to-order-btn" data-id="${food.id}">+</button>
            </div>
        `

        foodContainer.appendChild(foodItem)
    });

    if (foodList.length === 0) {
        foodContainer.innerHTML = '<p>No food items found!</p>'
    }

    const removeBtns = document.querySelectorAll(".remove-btn")

    removeBtns.forEach(button => {
        button.addEventListener("click", (e) => {
            const foodId = e.target.dataset.id
            removeFoodItem(foodId)
        })
    })

    const addToOrderBtns = document.querySelectorAll(".add-to-order-btn")

    addToOrderBtns.forEach(button => {
        button.addEventListener("click", (e) => {
            const foodToOrderId = e.target.dataset.id
            const foodToAdd = findFoodById(foodList, foodToOrderId)
            addFoodToOrder(foodToAdd)
        })
    })

}
