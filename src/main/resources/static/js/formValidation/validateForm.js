// Data should be validated more extensively, it's just for task purposes that I created it 

export function validateForm({name, ingredients, price, emoji}) {
    if (   
        name
        && name !== ""
        && ingredients
        && ingredients !== ""
        && price 
        && price !== ""
        && emoji
        && emoji !== ""
    ) {
        return true
    }
    return false
} 