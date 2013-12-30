Wei Zhou--SalesTaxes
==========

The Purpose:

Write an application that prints out the receipt details, including product price, tax valus, and total amoung of payment, for all the shopping products.

The Conditions:

Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.
The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

The Solutions:

1). Two big problems to be solved:

a. Get the sales order list of all product items from the user imput.

b. Calculate the tax values and total amount payment of the order list, and finally generate a receipt.

2). The Design:

Create a 'shopping store' to model the whole process, in which a 'store shelf' is used to populate various kinds of product items with their detail information; a 'shopping cart' is used to place the purchased product items; and a 'generate payment' center to perform the tax and total payment calcaulation operations.
The order of activities are perfomed as follows:

a. Through user's input, get the sales order of purchased product items;

b. Search and get the purchased products from the 'store shelf';

c. Place the products into the 'shopping cart';

d. Take the 'shopping cart' to the 'generate payment' center to check out;

e. The 'bill' center works on all tax and payment calculations and generate a receipt containing all of the necessary information.

The Running Process:
Based on the given example input information, I'v already added the relevant product names into the 'StoreShelf' class, as listed as follows:

a. book;

b. music CD;

c. chocolate bar;

d. box of chocolates;

e. bottle of perfume;

f. packet of headache pills;

When beginning run the application, please enter the same product name as above listed, or an NullPointerException will be caused, because the wrong product is inputed on the screen.
