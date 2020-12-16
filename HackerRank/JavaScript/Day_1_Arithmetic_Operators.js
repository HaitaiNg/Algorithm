/**
    Cacluate: the area of a rectangle 
    length : the length of the rectangle 
    width : width of the rectangle 
    return a number denoting the rectangle's area

    Calculate the perimter of a rectangle 
    return a number denoting permiter of a rectangle 
**/ 

function getArea(length, width){
    return length * width; 
}

function getPerimeter(length, width){
    return 2*(length + width); 
}

function main(){
    const length = +(readLine()); 
    const width = +(readLine()); 
    console.log(getArea(length, width)); 
    console.log(getPerimeter(length, width)); 
}