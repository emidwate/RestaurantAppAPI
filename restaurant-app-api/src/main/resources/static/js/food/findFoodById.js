export function findFoodById(array, id) {
    return (
        array.filter(item => {
            return item.id == id
        })[0]
    )
} 