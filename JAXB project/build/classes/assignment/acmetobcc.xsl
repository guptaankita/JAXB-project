<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="catalog">
		<!-- TODO: Auto-generated template -->
		<Library id="{@id}">
			<name>
				<xsl:value-of select="name">
				</xsl:value-of>
			</name>
			<books>

				<xsl:for-each select="manufacturers/Manufacturer">
					<xsl:variable name="author" select="name" />
					<xsl:for-each select="products/Product">
						<Book id="{@id}">
							<author>
								<xsl:value-of select="$author" />
							</author>
							<date_published>
								<xsl:value-of select="date_avaliable" />
							</date_published>
							<isbn>
								<xsl:value-of select="sku" />
							</isbn>
							<title>
								<xsl:value-of select="name" />
							</title>
							<synopsis>
								<xsl:value-of select="description" />
							</synopsis>
							<genre>
								<xsl:value-of select="category" />
							</genre>




						</Book>

					</xsl:for-each>
				</xsl:for-each>
			</books>


		</Library>
	</xsl:template>
</xsl:stylesheet>