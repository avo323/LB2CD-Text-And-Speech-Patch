;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2335)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2335Code 0
	pts2335 1
)

(local
	[thePoints 28] = [85 179 85 189 0 189 0 0 319 0 319 189 284 189 284 158 178 170 161 167 161 134 150 134 150 168 143 179]
	[thePoints_2 26] = [85 179 85 189 0 189 0 0 319 0 319 189 284 189 284 158 178 170 161 167 161 134 150 134 150 168]
)
(instance poly2335Code of Code
	(properties)
	
	(method (doit param1)
		(if (and (== global123 2) (not (proc0_2 25)))
			(param1 add: (poly2335a init: yourself:))
		else
			(param1 add: (poly2335b init: yourself:))
		)
	)
)

(instance poly2335a of Polygon
	(properties)
	
	(method (init)
		(= type 2)
		(= size 14)
		(= points @thePoints)
	)
)

(instance poly2335b of Polygon
	(properties)
	
	(method (init)
		(= type 2)
		(= size 13)
		(= points @thePoints_2)
	)
)

(instance pts2335 of MuseumPoints
	(properties)
)
