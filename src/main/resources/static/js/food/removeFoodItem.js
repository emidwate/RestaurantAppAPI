import { renderFoodList } from './renderFoodList.js'
import { getFoodList } from './fetchFoodList.js'

export async function removeFoodItem(foodId) {
    try {
        const response = await fetch(`http://localhost:8080/api/food/${foodId}`, {
            method: "DELETE"
        })
        if (response.ok) {
            // Refresh food list each time when new food is added
            const updatedFoodList = await getFoodList()
            renderFoodList(updatedFoodList)
        } else {
            console.error(`Failed to remove food: ${response.status}`)
        }
    } catch (error) {
        console.error(`Error: ${error}`)
    }
}