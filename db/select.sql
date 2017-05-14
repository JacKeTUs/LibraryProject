SELECT resource_name AS "Имя ресурса",
	resource_description AS "Описание",
	resource_link AS "Ссылка",
	type_value AS "Тип ресурса",
	theme_value AS "Тема",
	access_type_value AS "Тип доступа"

	FROM web_resources, type, theme, access_type

	WHERE 	resource_type = type.key AND
		resource_theme = theme.key AND
		resource_access_type = access_type.key
		
	ORDER BY resource_name