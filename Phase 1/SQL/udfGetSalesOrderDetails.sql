CREATE OR ALTER FUNCTION Sales.udfGetSalesOrderDetails(
	@SalesOrderID int,
	@CurrencyCode char(3),
	@date datetime)
	RETURNS table
	AS
	RETURN
		SELECT
			*,
			(sod.UnitPrice * 
			(SELECT 
				cr.EndOfDayRate
			FROM
			Sales.CurrencyRate as cr 
			WHERE 
				cr.ToCurrencyCode = @CurrencyCode 
					AND
				cr.CurrencyRateDate = @date
				)
			) as 'Target Unit Price '
		FROM
			Sales.SalesOrderDetail as sod
		WHERE sod.SalesOrderID = @SalesOrderID
		
