export function findFoodById(array, id) {
    return (
        array.filter(item => {
            return item.foodId == id
        })[0]
    )
} 