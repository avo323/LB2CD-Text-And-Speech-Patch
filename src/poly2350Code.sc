;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2350)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2350Code 0
	pts2350 1
)

(local
	[local0 32] = [0 156 38 156 87 120 231 120 304 157 319 157 319 179 278 179 255 161 240 161 233 154 94 154 90 161 70 161 44 179 0 179]
	[local32 44] = [0 156 38 156 66 136 6 136 6 125 69 125 69 134 87 120 231 120 304 136 304 157 319 157 319 179 278 179 255 161 240 161 233 154 94 154 90 161 70 161 44 179 0 179]
	[thePoints_2 12] = [91 177 88 171 96 166 223 166 231 171 227 177]
	[thePoints 20] = [91 177 88 171 96 166 223 166 231 171 227 177 210 177 202 185 133 185 125 177]
	[thePoints_3 16] = [0 0 319 0 319 99 281 99 281 66 259 66 259 97 0 97]
)
(instance poly2350Code of Code
	(properties)
	
	(method (doit param1)
		(param1
			add:
				(poly2350a init: yourself:)
				(poly2350b init: yourself:)
				(poly2350c init: yourself:)
		)
	)
)

(instance poly2350a of Polygon
	(properties)
	
	(method (init)
		(= size (if (>= global123 (= type 2)) 16 else 22))
		(= points (if (>= global123 2) @local0 else @local32))
	)
)

(instance poly2350b of Polygon
	(properties)
	
	(method (init)
		(= type 2)
		(if (proc999_5 global128 0 1 4 5 9 13)
			(= size 10)
			(= points @thePoints)
		else
			(= size 6)
			(= points @thePoints_2)
		)
	)
)

(instance poly2350c of Polygon
	(properties)
	
	(method (init)
		(= type 2)
		(= size 8)
		(= points @thePoints_3)
	)
)

(instance pts2350 of MuseumPoints
	(properties
		midPtX 275
		midPtY 120
		northPtX 264
		northPtY 86
		eastPtX 330
		eastPtY 120
		westPtX -10
		westPtY 120
	)
)
