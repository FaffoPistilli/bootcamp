-- Top clientes con más facturas
SELECT 
    c.nombre,
    c.apellido,
    COUNT(f.id) AS total_facturas
FROM 
    cliente c
INNER JOIN factura f ON c.id = f.cliente_id
GROUP BY c.id, c.nombre, c.apellido
ORDER BY total_facturas DESC;
			--Que hice:
--Unir las tablas de clientes y facturas.
--Contar el número de facturas por cada cliente.
--Ordena los resultados de mayor a menor.

-- Top clientes que más gastaron
SELECT 
    c.nombre,
    c.apellido,
    SUM(fd.cantidad * p.precio) AS total_gastado
FROM 
    cliente c
INNER JOIN factura f ON c.id = f.cliente_id
INNER JOIN factura_detalle fd ON f.id = fd.factura_id
INNER JOIN producto p ON fd.producto_id = p.id 
GROUP BY c.id, c.nombre, c.apellido
ORDER BY total_gastado DESC;
			--Que hice:
--Unir las tablas: cliente, factura, factura_detalle, pruducto.
--Calcular el subtotal de cada producto en cada factura (cantidad * precio).
--Sumar los subtotales de todos los productos de cada factura para obtener el total de cada factura.
--Agrupar los resultados por cliente.
--Sumar los totales de todas las facturas de cada cliente para obtener el gasto total.
--Ordenar los resultados de mayor a menor según el gasto total.

-- Top monedas más utilizadas
SELECT
    m.nombre AS moneda,
    COUNT(*) AS monedas_mas_utilizadas
FROM
    factura f
INNER JOIN moneda m ON f.moneda_id = m.id
GROUP BY
    m.nombre
ORDER BY
    monedas_mas_utilizadas DESC;
			--Que hice:
--Seleccionar el nombre de la moneda y contar la cantidad de facturas para cada moneda.
--Iniciar la consulta desde la tabla de facturas (alias f).
--Unir la tabla de facturas con la tabla de monedas utilizando el campo moneda_id como enlace.
--Agrupar los resultados por el nombre de la moneda.
--Ordenar los resultados

-- Top proveedor de productos
SELECT
    p.proveedor_id,
    COUNT(*) AS cantidad_productos
FROM
    producto p
GROUP BY
    p.proveedor_id
ORDER BY
    cantidad_productos DESC;
		--Que hice:
--Unir las tablas de proveedores y productos para relacionar cada producto con su proveedor.
--Agrupar los resultados por proveedor.
--Contar la cantidad de productos por cada proveedor.
--Ordenar los resultados de mayor a menor segun la cantidad de productos.

-- Productos más vendidos
SELECT
    p.id,
    p.nombre,
    SUM(fd.cantidad) AS total_vendido
FROM
    factura_detalle fd
INNER JOIN producto p ON fd.producto_id = p.id
GROUP BY
    p.id, p.nombre
ORDER BY
    total_vendido DESC; 
		--Que hice: 
--Seleccionar el ID, nombre del producto y sumar la cantidad vendida de cada producto
--Iniciar la consulta desde la tabla de detalles de factura.
--Unir la tabla de detalles de factura con la tabla de productos utilizando el ID del producto como enlace.
--Agrupar los resultados por el ID y nombre del producto.
--Ordenar los resultados de forma descendente según la cantidad total vendida.


-- Productos menos vendidos
SELECT
    p.id,
    p.nombre,
    SUM(fd.cantidad) AS total_vendido
FROM
    factura_detalle fd
INNER JOIN producto p ON fd.producto_id = p.id
GROUP BY p.id, p.nombre
ORDER BY total_vendido ASC;


-- Consulta que muestra fecha de emisión de factura, nombre y apellido del cliente, 
--nombres de productos de esa factura, 
--cantidades compradas ,nombre de tipo de factura de una factura específica
--Probamos con la factura_id = 97

SELECT
    f.fecha_emision,
    c.nombre || ' ' || c.apellido AS cliente,
    p.nombre AS producto,
    df.cantidad,
    tf.nombre AS tipo_factura
FROM
    factura f
INNER JOIN cliente c ON f.cliente_id = c.id
INNER JOIN factura_detalle df ON f.id = df.factura_id
INNER JOIN producto p ON df.producto_id = p.id
INNER JOIN factura_tipo tf ON f.factura_tipo_id = tf.id
WHERE
    f.id = 97;
	
-- Montos de facturas ordenados según totales
-- Mostrar el IVA del 10% de los montos totales de facturas
-- (suponer que todos los productos tienen IVA del 10%)
SELECT
    f.id AS numero_factura,
    SUM(df.cantidad * p.precio) AS total_factura,
    SUM(df.cantidad * p.precio) * 0.10 AS iva
FROM
    factura f
INNER JOIN factura_detalle df ON f.id = df.factura_id
INNER JOIN producto p ON df.producto_id = p.id
GROUP BY
    f.id
ORDER BY
    total_factura DESC;