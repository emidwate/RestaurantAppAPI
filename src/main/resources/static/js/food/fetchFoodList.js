export async function getFoodList() {
    try {
        const response = await fetch("http://localhost:8080/api/foodList")
        if (!response.ok) {
            console.error(`Failed to fetch: ${response.status} ${response.statusText}`)
        }
        const data = await response.json()
        return data
    } catch (error) {
        console.error(`Error fetching food list: ${error}`)
    }
}