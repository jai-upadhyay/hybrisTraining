CREATE PROCEDURE Person.uspFilterPerson (@firstNameFilter as nvarchar(50))
AS
BEGIN
	SELECT
		*
	FROM
		Person.Person as p
	WHERE
		p.FirstName LIKE '%'+@firstNameFilter+'%';
END;

ALTER PROCEDURE Person.uspFilterPerson (@firstNameFilter as nvarchar(50) = 'Ruth')
AS
BEGIN
	SELECT
		*
	FROM
		Person.Person as p
	WHERE
		p.FirstName LIKE '%'+@firstNameFilter+'%';
END;
