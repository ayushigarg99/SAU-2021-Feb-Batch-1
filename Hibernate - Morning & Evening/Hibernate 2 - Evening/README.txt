Hibernate 2 Assignment 
1. Developed an Ecommerce Management System which has one to many association between Product to Categories and many to many association between Supplier and Categories.

2. Fix the problem in Many to Many example
 
Solution - To solve the problem, following changes are made
a) Used JoinColumn in Item class to map with Category class instead of mappedBy.
b) Create a set of categories also and added them to items to maintain many to many association.

3. Created a Many to One association between User and Vehicle.