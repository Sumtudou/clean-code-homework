| No   | modify file                      | modify            | detail                                                      |
| ---- | -------------------------------- | ----------------- | ----------------------------------------------------------- |
| 1    | OrderReceipt.java                | rename            | rename o to order                                           |
| 2    | OrderReceipt.java                | dead code         | remove dead code and useless comment                        |
| 3    | OrderReceipt.java                | deprecated method | remove deprecated method                                    |
| 4    | OrderReceipt.java                | magical number    | extract magical number                                      |
| 5    | OrderReceipt.java, LineItem.java | rename            | rename some variable                                        |
| 6    | OrderReceipt.java                | long method       | extract some methods                                        |
| 7    | OrderReceipt.java, LineItem.java | feature envy      | extract method from OrderReceipt to LineItem                |
| 8    | OrderReceipt.java                | magical number    | extract constant                                            |
| 9    | OrderReceipt.java, order.java    | feature envy      | extract getOrderReceiptContent() getTotalSalesTx() to order |
| 10   | OrderReceipt.java, order.java    | feature envy      | extract totalPrice to order                                 |
| 11   | OrderReceipt.java                | long method       | extract 2 method from generateReceipt                       |

