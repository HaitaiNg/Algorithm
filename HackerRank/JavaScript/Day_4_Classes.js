/*
 * Implement a Polygon class with the following properties:
 * 1. A constructor that takes an array of integer side lengths.
 * 2. A 'perimeter' method that returns the sum of the Polygon's side lengths.
 */

class Polygon{
    constructor(array){
        this.lengths = array; 
    }
    
    perimeter(){
     var length = 0;
     for( var i = 0; i < this.lengths.length; i++){
         length += this.lengths[i]; 
     }   
     return length; 
    }
}


