import { renderFoodList } from './renderFoodList.js'
import { getFoodList } from './fetchFoodList.js'

export async function addNewFood(food) {
    try {
        const response = await fetch("http://localhost:8080/api/food", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(food)
        })
        if (response.ok) {
            // Refresh food list each time when new food is added
            const updatedFoodList = await getFoodList()
            renderFoodList(updatedFoodList)
        } else {
            console.error(`Failed to add food ${response.status}`)
        }
    } catch (error) {
        console.error(`Error occurred while adding food: ${error}`)
    }
}