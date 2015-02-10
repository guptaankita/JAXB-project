<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="library">
		<!-- TODO: Auto-generated template -->
		<catalog id="{@id}">
			<name>
				<xsl:value-of select="name" />
			</name>
			<manufacturers>
				<xsl:for-each-group select="books/Book" group-by="author">
					<Manufacturer>
						<name>
							<xsl:value-of select="current-grouping-key()" />
						</name>
						<products>
							<xsl:for-each select="current-group()">
								<Product>
									<sku>
										<xsl:value-of select="isbn" />
									</sku>
									<name>
									<xsl:value-of select="title"/>
									</name>
									<description>
									<xsl:value-of select="synopsis"/>
									</description>
									<category>
									<xsl:value-of select="genre"/>
									</category>
									<date_avaliable>
									<xsl:value-of select="date_published"/>
									</date_avaliable>
								</Product>
							</xsl:for-each>

						</products>
					</Manufacturer>
				</xsl:for-each-group>
			</manufacturers>
		</catalog>

	</xsl:template>
</xsl:stylesheet>