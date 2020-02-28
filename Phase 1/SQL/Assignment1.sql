use AdventureWorks;
--/**
--EXERCISE 1
--*/

----1
--SELECT COUNT(*)
--FROM 
--Sales.SalesPerson;

----2

--SELECT 
--FirstName,
--LastName
--FROM
--Person.Person
--WHERE
--FirstName LIKE 'B%';

----3
--SELECT 
--FirstName,
--LastName
--FROM
--Person.Person
--INNER JOIN
--HumanResources.Employee
--ON
--Person.BusinessEntityID = Employee.BusinessEntityID
--WHERE
--JobTitle = 'Design Engineer' OR JobTitle = 'Tool Designer' OR JobTitle = 'Marketing Assistant';


----4

--SELECT 
--	Name,
--	Color 
--FROM
--	Production.Product
--WHERE 
--	Weight = (
--		SELECT  
--			MAX(Weight) AS MaxWeight
--		FROM 
--			Production.Product);

----5

--SELECT
--	Description,
--	ISNULL(	MaxQty, 0) MaxQty
--FROM
--	Sales.SpecialOffer;

----6
--SELECT
--	AVG(AverageRate) AverageRateOfTheDay
--FROM
--	Sales.CurrencyRate
--WHERE
--	FromCurrencyCode = 'USD'
--		AND
--	ToCurrencyCode = 'GBP'
--		AND
--		(
--			CurrencyRateDate >= '2013-01-01 00:00:00.000'
--				AND
--			CurrencyRateDate <= '2013-12-31 00:00:00.000'		
--		);
	
----7

--SELECT
--	ROW_NUMBER() OVER (ORDER BY FirstName) AS SrNumber,
--	FirstName,
--	LastName
--FROM
--	Person.Person
--WHERE
--	FirstName LIKE '%ss%';

----8

--SELECT
--	BusinessEntityID,
--	CASE 
--		WHEN CommissionPct <= 0.000 THEN 'Band 0'
--		WHEN CommissionPct BETWEEN 0.000 AND 0.010 THEN 'Band 1'
--		WHEN CommissionPct BETWEEN 0.010 AND 0.015 THEN 'Band 2'
--	ELSE 'Band 3'
--	END AS 'Commision Band'
--FROM
--	Sales.SalesPerson;

----9

--DECLARE @ruthID int = (SELECT Person.udfGetBEID('EM', 'Ruth'));
--EXEC dbo.uspGetEmployeeManagers @ruthID;




----10
--SELECT 
--dbo.ufnGetStock(ProductID) StockLevel,
-- ProductID
-- FROM
-- Production.Product
-- WHERE
-- DBO.ufnGetStock(ProductID) = 
--(SELECT 
-- MAX(dbo.ufnGetStock(ProductID) ) getStock
-- FROM
--	Production.Product);

--2


----USING SUBQUERY

--SELECT
--	*
--FROM
--	Sales.Customer;




--SELECT
--	*
--FROM
--	Sales.Customer as sc
--WHERE
--	sc.CustomerID NOT IN (
--		SELECT 
--			CustomerID
--		FROM
--			Sales.SalesOrderHeader
--		)
	
----USING JOIN
--SELECT
--	*
--FROM
--	Sales.Customer as sc 
--INNER JOIN Sales.SalesOrderHeader as soh
--	ON  soh.CustomerID = sc.CustomerID
--ORDER BY
--	sc.CustomerID;

----using cte

--WITH customer_who_ordered AS
--(
--	SELECT DISTINCT
--		CustomerID
--	FROM
--		Sales.SalesOrderHeader
	
--)

--Select 
--	CustomerID
--FROM
--	Sales.Customer as sc
--	EXCEPT
--		SELECT 
--			CustomerID
--		FROM
--			customer_who_ordered;

---- exist
--SELECT
--	*
--FROM
--	Sales.Customer as sc
--WHERE
--	NOT EXISTS(
--		SELECT 
--			CustomerID
--		FROM
--			Sales.SalesOrderHeader soh
--		WHERE
--			sc.CustomerID = soh.CustomerID
--		)
--ORDER BY CustomerID;

----4


--SELECT * FROM Sales.udfGetSalesOrderDetails(43659, 'AUD','2011-05-31 00:00:00.000');


----5

--EXEC Person.uspFilterPerson 'Ken';



