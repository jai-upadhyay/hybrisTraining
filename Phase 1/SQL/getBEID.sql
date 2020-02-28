CREATE OR ALTER FUNCTION Person.udfGetBEID(@personType nchar(2), @firstName nvarchar(50))
	RETURNS int 
	as
BEGIN;
	DECLARE @beID int;

		SELECT @beID = BusinessEntityID 
		FROM
		Person.Person
		WHERE
		PersonType = @personType
		AND
		FirstName = @firstName;
		RETURN @beID;
	
END;

