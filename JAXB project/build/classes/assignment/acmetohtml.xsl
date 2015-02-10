<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="catalog">
		<h1><xsl:value-of select="name"/></h1>
		<h1>Products Grouped By Manufacturers</h1>
		<table>
        <thead>
          <tr>
            <th>Sku</th>
            <th> Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Category</th>
            <th>SubCategory</th>
            <th>Date Avaliable</th>
          </tr>
        </thead>
        <tbody>
        
         <xsl:for-each select="manufacturers/Manufacturer">
		<tr>
		<td colspan="7">Manufacturer : <xsl:value-of select="name"/></td>
		</tr>
		<xsl:for-each select="products/Product">
	<tr>
				  <td><xsl:value-of select="sku"/></td>
				  <td><xsl:value-of select="name"/></td>
				  <td><xsl:value-of select="description"/></td>
				  <td><xsl:value-of select="price"/></td>
				  <td><xsl:value-of select="category"/></td>
				  <td><xsl:value-of select="subcategory"/></td>
				  
				  
				  <td><xsl:value-of select="date_avaliable"/></td>
				  
			    </tr>
				</xsl:for-each>
				</xsl:for-each>
				
    		    	
	    	</tbody>
    </table>
	</xsl:template>
	
</xsl:stylesheet>